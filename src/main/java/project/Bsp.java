//import org.json.JSONObject;
//import sun.misc.BASE64Encoder;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import javax.net.ssl.*;
//import java.io.*;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.X509Certificate;
//import java.sql.SQLOutput;
//import java.util.*;
//
///**
// * 天御服务API工具类
// */
//class BspAPI {
//    /* Basic request URL */
//    private static final String URL = "fiv.tencentcloudapi.com/";
//
//    /**
//     * 编码
//     *
//     * @param bstr
//     * @return String
//     */
//    private static String encode(byte[] bstr) {
//        return new BASE64Encoder().encode(bstr);
//    }
//
//    /* Signature algorithm using HMAC-SHA1 */
//    public static String hmacSHA1(String key, String text, String charset) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
//        Mac mac = Mac.getInstance("HmacSHA1");
//        mac.init(new SecretKeySpec(key.getBytes(charset), "HmacSHA1"));
//        return encode(mac.doFinal(text.getBytes(charset)));
//    }
//
//    /* Assemble query string */
//    private static String makeQueryString(Map<String, String> args, String charset) throws UnsupportedEncodingException {
//        String url = "";
//
//        for (Map.Entry<String, String> entry : args.entrySet())
//            url += entry.getKey() + "=" + (charset == null ? entry.getValue() : URLEncoder.encode(entry.getValue(), charset)) + "&";
//
//        return url.substring(0, url.length() - 1);
//    }
//
//    /* Generates an available URL */
//    public static String makeURL(
//            String method,
//            String action,
//            String region,
//            String secretId,
//            String secretKey,
//            Map<String, String> args,
//            String charset)
//            throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
//        SortedMap<String, String> arguments = new TreeMap<String, String>();
//
//        /* Sort all parameters, then calculate signature */
//        arguments.putAll(args);
//        arguments.put("Nonce", String.valueOf((int) (Math.random() * 0x7fffffff)));
//        arguments.put("Action", action);
//        arguments.put("Region", region);
//        arguments.put("SecretId", secretId);
//        arguments.put("Timestamp", String.valueOf(System.currentTimeMillis() / 1000));
//        arguments.put("Signature", hmacSHA1(secretKey, String.format("%s%s?%s", method, URL, makeQueryString(arguments, null)), charset));
////        System.out.println(String.format("https://%s?%s", URL, makeQueryString(arguments, charset)));
//
//        /* Assemble final request URL */
//        return String.format("https://%s?%s", URL, makeQueryString(arguments, charset));
//    }
//}
//
//
///**
// * Http 请求工具类
// */
//class ApiRequest {
//    /**
//     * Get 请求
//     *
//     * @param url    http请求地址
//     * @param params http请求参数
//     * @return String
//     */
//    public static ApiResponse sendGet(String url, String params) {
//        BufferedReader br = null;
//        ApiResponse response = new ApiResponse();
//        try {
//            String urlNameString = url;
//            if (0 != params.length()) {
//                String linkOperator = urlNameString.contains("?") ? "&" : "?";
//                urlNameString += linkOperator + params;
//            }
//            TrustManager[] trustAllCerts = new TrustManager[]{
//                    new X509TrustManager() {
//                        public X509Certificate[] getAcceptedIssuers() {
//                            return null;
//                        }
//
//                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
//                            // don't check
//                        }
//
//                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
//                            // don't check
//                        }
//                    }
//            };
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustAllCerts, null);
//            SSLSocketFactory ssf = sslContext.getSocketFactory();
//            HttpsURLConnection connection = (HttpsURLConnection) new URL(urlNameString).openConnection();
//            connection.setSSLSocketFactory(ssf);
//
//            // 设置请求头
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//
//            connection.connect();
//
//            // 获取请求头字段
//            Map<String, List<String>> header = connection.getHeaderFields();
//
//            // 获取URL的输入流，读取请求响应
//            String body = readString(connection.getInputStream());
//            response.setHeader(header);
//            response.setBody(body);
//
//        } catch (Exception e) {
//            System.out.println("发送GET请求出现异常!" + e);
//            e.printStackTrace();
//        }
//
//        return response;
//    }
//
//    /**
//     * POST 请求
//     *
//     * @param url    http请求地址
//     * @param params http请求参数
//     * @return String
//     */
//    public static ApiResponse sendPost(String url, String params) {
//        PrintWriter pw = null;
//        BufferedReader br = null;
//        ApiResponse response = new ApiResponse();
//        try {
//            TrustManager[] trustAllCerts = new TrustManager[]{
//                    new X509TrustManager() {
//                        public X509Certificate[] getAcceptedIssuers() {
//                            return null;
//                        }
//
//                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
//                            // don't check
//                        }
//
//                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
//                            // don't check
//                        }
//                    }
//            };
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustAllCerts, null);
//            SSLSocketFactory ssf = sslContext.getSocketFactory();
//
//            HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
//            connection.setSSLSocketFactory(ssf);
//
//            // 设置请求头
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//
//            // 设置 POST
//            connection.setRequestMethod("POST");
//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            // Post 请求不能使用缓存
//            connection.setUseCaches(false);
//
//            connection.setConnectTimeout(5000);
//
//            // 获取URL的输出流, 发送请求参数
//            pw = new PrintWriter(connection.getOutputStream());
//            pw.print(params);
//            pw.flush();
//
//            // 获取请求头字段
//            Map<String, List<String>> header = connection.getHeaderFields();
//
//            // 获取URL的输入流，读取请求响应
//            String body = readString(connection.getInputStream());
//
//            response.setHeader(header);
//            response.setBody(body);
//
//        } catch (Exception e) {
//            System.out.println("发送POST请求出现异常!" + e);
//            e.printStackTrace();
//        } finally {
//            try {
//                if (pw != null) {
//                    pw.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return response;
//    }
//
//
//    private static String readString(InputStream is) {
//        BufferedReader br = null;
//        String content = "";
//        try {
//            br = new BufferedReader(new InputStreamReader(is, "utf-8"));
//            String line;
//            while ((line = br.readLine()) != null) {
//                content += line;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (br != null) {
//                    br.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return content;
//    }
//}
//
///**
// * Http 请求响应
// */
//class ApiResponse {
//    private Map header;
//    private Object body;
//
//    public ApiResponse() {
//        this.header = new TreeMap();
//        this.body = "";
//    }
//
//    public ApiResponse(Map header, String body) {
//        this.header = header;
//        this.body = body;
//    }
//
//    public void setHeader(Map header) {
//        this.header = header;
//    }
//
//    public Map getHeader() {
//        return this.header;
//    }
//
//    public void setBody(Object body) {
//        this.body = body;
//    }
//
//    public Object getBody() {
//        return this.body;
//    }
//}
//
///* Demo section */
//public class BspBankCardAuth4 {
//
//    public static void main(String[] argv) throws Exception {
//        /* 密钥,请进行替换,密钥申请地址 https://console.qcloud.com/capi  */
//        final String SECRET_ID = "待填写";
//        final String SECRET_KEY = "待填写";
//        System.setProperty("https.proxyHost", "web-proxy.tencent.com");
//        System.setProperty("https.proxyPort", "8080");
//        Map<String, String> args = new TreeMap<String, String>();
//        // BspBankCardAuth4
//        args.put("IdNumber", "身份证");
//        args.put("Name", "姓名");
//		args.put("BankCardNumber","银行卡号");
//		args.put("PhoneNumber", "手机号");
//        args.put("Version" ,"2019-05-21");
//        //二要素action为BspIdCardAuth
//        //三要素action为BspMobileAuth3
//        //测试二、三要素事，修改下面的action字段
//        String url = BspAPI.makeURL("GET", "BspBankCardAuth4","ap-guangzhou",SECRET_ID, SECRET_KEY, args, "utf-8");
//        System.out.println(url);
//        ApiResponse res = ApiRequest.sendGet(url, "");
//        System.out.println(res.getBody());
//    }
//}