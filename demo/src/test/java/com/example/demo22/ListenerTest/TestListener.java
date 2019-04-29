package com.example.demo22.ListenerTest;

/**
 * @ClassName TestListener
 * @Description TODO
 * @Author chenbilang
 * @Date 2019/4/23
 * @Version 1.0
 */
public class TestListener {
    public static void main(String[] args) {
        Person person = new Person();
        person.registerListener(new MyPersonListener());
        person.run();
        person.eat();
    }//实现监听器接口中的方法
}
    class MyPersonListener implements PersonListener {
        @Override
        public void dorun() {
            System.out.println("人在跑之前执行的动作");

        }

        @Override
        public void doeat() {
            System.out.println("人在吃之前执行的动作");

        }
//        @Override
//        public void dorun(Even even) {
//            Person person = even.getPerson(); //拿到事件源
//            System.out.println("人在跑之前执行的动作");
//        }
//
//        @Override
//        public void doeat(Even even) {
//            System.out.println("人在吃之前执行的动作");
//        }
    }

