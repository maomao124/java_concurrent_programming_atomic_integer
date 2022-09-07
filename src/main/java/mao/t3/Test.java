package mao.t3;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Project name(项目名称)：java并发编程_原子整数
 * Package(包名): mao.t3
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/7
 * Time(创建时间)： 11:32
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        System.out.println(atomicBoolean.getAndSet(false));
        System.out.println(atomicBoolean.get());
    }
}
