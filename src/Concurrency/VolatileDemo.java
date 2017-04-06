package Concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 证明volatile不能保证多线程操作共享变量原子性的示例，以及该问题的解决方法
 * @author westear
 * 2017年4月6日
 */
public class VolatileDemo {

	public static void main(String[] args){
		
		//测试volatile原子性,得出volatile无法保证多线程操作的原子性
		final AtomicityTest auAtomicityTest = new AtomicityTest();
		for(int i = 0; i < 100; i++){
			new Thread(){	//建立10个线程
				public void run(){
					for(int j = 0; j < 1000; j++){
						auAtomicityTest.increase();
					}
				}
			}.start();
		}
		
		while(Thread.activeCount() > 1){	//保证前面的线程都执行完
			Thread.yield();
		}
		System.out.println("answer always lower than 100*1000: " + auAtomicityTest.inc);	//answer always lower than 100*1000
		
		/**
		 * 解决方法:1.synchronized; 2.Lock; 3.AtomicInteger 
		 */
		//1.synchronized
		final SynchronizedTest synchronizedTest = new SynchronizedTest();
		for(int i = 0; i < 100; i++){
			new Thread(){	//建立10个线程
				public void run(){
					for(int j = 0; j < 1000; j++){
						synchronizedTest.increase();
					}
				}
			}.start();
		}
		
		while(Thread.activeCount() > 1){	//保证前面的线程都执行完
			Thread.yield();
		}
		System.out.println("synchronized: "+synchronizedTest.inc);
		
		//2.ReentrantLock
		final LockTest lockTest = new LockTest();
		for(int i = 0; i < 100; i++){
			new Thread(){	//建立10个线程
				public void run(){
					for(int j = 0; j < 1000; j++){
						lockTest.increase();
					}
				}
			}.start();
		}
		
		while(Thread.activeCount() > 1){	//保证前面的线程都执行完
			Thread.yield();
		}
		System.out.println("ReentrantLock: "+lockTest.inc);
		
		//3.AtomicInteger
		final AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
		for(int i = 0; i < 100; i++){
			new Thread(){	//建立10个线程
				public void run(){
					for(int j = 0; j < 1000; j++){
						atomicIntegerTest.increase();
					}
				}
			}.start();
		}
		
		while(Thread.activeCount() > 1){	//保证前面的线程都执行完
			Thread.yield();
		}
		System.out.println("AtomicInteger: "+atomicIntegerTest.inc);
		
		
	}
}

/**
 * 原子性测试,volatile无法保证原子性
 * @author westear
 * 2017年4月6日
 */
class AtomicityTest{
	public volatile int inc = 0;
	
	public void increase(){
		//完成后立即更新主存中volatile修饰变量值
		inc++;	//操作步骤分解：1.从主存中取变量当前值；2.进行+1操作；3.写入工作内存。所以操作不具有原子性
	}
}

/**
 * 使用synchronized关键字解决以上问题
 * @author westear
 * 2017年4月6日
 */
class SynchronizedTest{
	public int inc = 0;
	
	public synchronized void increase(){
		inc++;
	}
}

/**
 * 使用ReentrantLock解决以上问题
 * @author westear
 * 2017年4月6日
 */
class LockTest{
	public int inc = 0;
	
	Lock lock = new ReentrantLock();
	
	public void increase(){
		lock.lock();
		try{
			inc++;
		}finally {
			lock.unlock();
		}
	}
}

/**
 * 使用AtomicInteger解决以上问题
 * @author westear
 * 2017年4月6日
 */
class AtomicIntegerTest{
	//An int value that may be updated atomically
	public AtomicInteger inc = new AtomicInteger();
	
	public void increase(){
		inc.getAndIncrement();
	}
}