package mao.t1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * Project name(项目名称)：java并发编程_原子整数
 * Package(包名): mao.t1
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 11:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        AtomicInteger i = new AtomicInteger(0);
        // 获取并自增（i = 0, 结果 i = 1, 返回 0），类似于 i++
        System.out.println(i.getAndIncrement());
        // 自增并获取（i = 1, 结果 i = 2, 返回 2），类似于 ++i
        System.out.println(i.incrementAndGet());
        // 自减并获取（i = 2, 结果 i = 1, 返回 1），类似于 --i
        System.out.println(i.decrementAndGet());
        // 获取并自减（i = 1, 结果 i = 0, 返回 1），类似于 i--
        System.out.println(i.getAndDecrement());
        // 获取并加值（i = 0, 结果 i = 5, 返回 0）
        System.out.println(i.getAndAdd(5));
        // 加值并获取（i = 5, 结果 i = 0, 返回 0）
        System.out.println(i.addAndGet(-5));
        // 获取并更新（i = 0, p 为 i 的当前值, 结果 i = -2, 返回 0）
        // 其中函数中的操作能保证原子，但函数需要无副作用
        //System.out.println(i.getAndUpdate(p -> p - 2));
        System.out.println(i.getAndUpdate(new IntUnaryOperator()
        {
            @Override
            public int applyAsInt(int operand)
            {
                return operand - 2;
            }
        }));
        // 更新并获取（i = -2, p 为 i 的当前值, 结果 i = 0, 返回 0）
        // 其中函数中的操作能保证原子，但函数需要无副作用
        //System.out.println(i.updateAndGet(p -> p + 2));
        System.out.println(i.updateAndGet(new IntUnaryOperator()
        {
            @Override
            public int applyAsInt(int operand)
            {
                return operand + 2;
            }
        }));
        // 获取并计算（i = 0, p 为 i 的当前值, x 为参数1, 结果 i = 10, 返回 0）
        // 其中函数中的操作能保证原子，但函数需要无副作用
        // getAndUpdate 如果在 lambda 中引用了外部的局部变量，要保证该局部变量是 final 的
        // getAndAccumulate 可以通过 参数1 来引用外部的局部变量，但因为其不在 lambda 中因此不必是 final
        //System.out.println(i.getAndAccumulate(10, (p, x) -> p + x));
        System.out.println(i.getAndAccumulate(10, new IntBinaryOperator()
        {
            @Override
            public int applyAsInt(int left, int right)
            {
                return left + right;
            }
        }));
        // 计算并获取（i = 10, p 为 i 的当前值, x 为参数1, 结果 i = 0, 返回 0）
        // 其中函数中的操作能保证原子，但函数需要无副作用
        //System.out.println(i.accumulateAndGet(-10, (p, x) -> p + x));
        System.out.println(i.accumulateAndGet(-10, new IntBinaryOperator()
        {
            @Override
            public int applyAsInt(int left, int right)
            {
                return left + right;
            }
        }));
    }
}
