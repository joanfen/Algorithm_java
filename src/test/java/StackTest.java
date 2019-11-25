import Stack.StackOperation;
import Stack.StackQueue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class StackTest {

    @Test
    public void TestStackQueue() {
        StackQueue queue = new StackQueue();
        queue.push(1);
        int param2 = queue.peek();
        Assert.assertEquals(1, param2);

        queue.pop();
        Assert.assertTrue(queue.empty());

        queue.push(2);
        queue.push(3);
        queue.push(4);
        Assert.assertEquals(2, queue.peek());

    }

    @Test
    public void testRemoveDuplicates() {
        StackOperation operation = new StackOperation();
        String result = operation.removeDuplicates("abbaca");
        Assert.assertEquals("ca", result);
    }

    @Test
    public void testValidParentheses() {
        StackOperation operation = new StackOperation();
        Assert.assertFalse(operation.validParentheses("(]"));
        Assert.assertTrue(operation.validParentheses("()"));
        Assert.assertTrue(operation.validParentheses("{([])}"));


    }


}
