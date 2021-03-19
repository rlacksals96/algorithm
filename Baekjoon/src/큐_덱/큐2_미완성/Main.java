package 큐_덱.큐2_미완성;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//pop() 구현 문제로 인해 중도포기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        MyQueue q=new MyQueue();

        for(int i=0;i<n;i++){
            String []command=br.readLine().split(" ");
            switch (command[0]){
                case "push":
                    q.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    System.out.println("pop "+q.pop());
                    break;
                case "empty":
                    System.out.println(q.isEmpty());
                    break;
                case "front":
                    System.out.println(q.getFront());
                    break;
                case "size":
                    System.out.println(q.getSize());
                    break;
                case "back":
                    System.out.println(q.getBack());
                    break;
                default:
                    break;
            }
        }

    }
}
class MyQueue {

    private int size = 0;
    private Node head;
    private Node prevHead;
    private Node tail;
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public int getFront(){
        return head.value;
    }
    public int getBack(){
        return tail.value;
    }
    public int isEmpty() {
        if (head == null)
            return 1;
        else
            return 0;
    }

    public int getSize() {
        return size;
    }

    public int pop(){
        if(tail==null){
            return -1;
        }
        else if(tail==head){
            int k=tail.value;
            tail=null;
            head=null;
            return k;
        }
        else{
            Node tmp=tail;
            int k=0;
            while(tmp!=null){
                prevHead=tmp;
                k=prevHead.value;
                tmp=tmp.next;

            }

            prevHead.next=null;
            head=prevHead;
            return k;
        }

    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (head == null && tail==null) {
            head =newNode;
            tail=newNode;
        } else {
            newNode.next = tail;
            tail=newNode;


        }
        size++;
    }


}