package com.sdyin.design.other;

import com.sdyin.design.singleton.ThreadPoolUtils;
import org.springframework.cglib.core.TinyBitSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import static com.sdyin.design.other.BlockingQueueDemo.*;

/**
 * CompletionService 示例demo:批量异步任务,内部封装维护阻塞队列
 * @Description
 * @Author liuye
 * @Date 2019/8/11 10:29
 */
public class CompletionServiceDemo {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPool = ThreadPoolUtils.getThreadPool();
        List<Future<Integer>> list = new ArrayList<>();
        //创建 CompletionService,第二个参数不指定则默认为 LinkedBlockingQueue
        CompletionService<Integer> cs = new ExecutorCompletionService<>(threadPool);
        Future<Integer> f1 = cs.submit(() -> getOrderPrice1());
        Future<Integer> f2 = cs.submit(() -> getOrderPrice2());
        Future<Integer> f3 = cs.submit(() -> getOrderPrice3());
        //保存
        /*for (int i = 0; i < 3; i++) {
            Integer result = cs.take().get();
            threadPool.submit(()->saveOrder(result));
        }*/

        System.out.println("---------------------------------");
        //任一成功即使结束
        list.add(f1);
        list.add(f2);
        list.add(f3);
        try {
            for (int i = 0; i < 3; i++) {
                Integer result = cs.take().get();
                threadPool.submit(()->saveOrder(result));
                break;
            }
        } finally {
            // 取消其余任务
            for (Future future: list) {
                System.out.println("取消任务:" + future.toString());
                future.cancel(true);
            }
        }
    }

}
