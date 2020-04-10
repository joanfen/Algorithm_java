import java.util.Random;

/**
 * @ProjectName: Treasures
 * @Package: com.hchc.treasures.utils
 * @ClassName: InviteCodeUtils
 * @Description: java类作用描述 邀请码生成器
 * @Author: WaveJuJu
 * @CreateDate: 2019-12-23 17:04
 */
public class InviteCodeUtils {
    private static final char[] BASE = new char[]{'H', 'V', 'E', '8', 'S', '2', 'D', 'Z', 'X', '9', 'C', '7', 'P',
            '5', 'I', 'K', '3', 'M', 'J', 'U', 'F', 'R', '4', 'W', 'Y', 'L', 'T', 'N', '6', 'B', 'G', 'Q'};
    private static final char SUFFIX_CHAR = 'A';
    private static final int BIN_LEN = BASE.length;
    private static final int CODE_LEN = 6;

    public static String idToCode(Long id) {
        char[] buf = new char[BIN_LEN];
        int charPos = BIN_LEN;
        // 当id除以数组长度结果大于0，则进行取模操作，并以取模的值作为数组的坐标获得对应的字符
        while (id / BIN_LEN > 0) {
            int index = (int) (id % BIN_LEN);
            buf[--charPos] = BASE[index];
            id /= BIN_LEN;
        }
        buf[--charPos] = BASE[(int) (id % BIN_LEN)];
        // 将字符数组转化为字符串
        String result =  new String(buf, charPos, BIN_LEN - charPos);
        // 长度不足指定长度则随机补全
        int len = result.length();
        if (len < CODE_LEN) {
            StringBuilder sb = new StringBuilder();
            sb.append(SUFFIX_CHAR);
            Random random = new Random();
            // 去除SUFFIX_CHAR本身占位之后需要补齐的位数
            for (int i = 0; i < CODE_LEN - len - 1; i++) {
                sb.append(BASE[random.nextInt(BIN_LEN)]);
            }

            result += sb.toString();
        }

        return result;
    }

    public static Long codeToId(String code) {
        char[] charArray = code.toCharArray();
        long result = 0L;
        for (int i = 0; i < charArray.length; i++) {
            int index = 0;
            for (int j = 0; j < BIN_LEN; j++) {
                if (charArray[i] == BASE[j]) {
                    index = j;
                    break;
                }
            }
            if (charArray[i] == SUFFIX_CHAR) {
                break;
            }
            if (i > 0) {
                result = result * BIN_LEN + index;
            } else {
                result = index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Long originCode = 201912211L;
        String code = idToCode(originCode);
        System.out.println();
        System.out.println("原始值: " + originCode + "，加密后值: " + code);
        System.out.println("code: " + code + "，解密后值: " + codeToId(code));
    }
}
