package stack.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        MyStack s=new MyStack();

        for(int i=0;i<n;i++){
            String []command=br.readLine().split(" ");

            switch (command[0]){
                case "push":
                    s.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    System.out.println(s.pop());
                    break;
                case "size":
                    System.out.println(s.getSize());
                    break;
                case "empty":
                    System.out.println(s.isEmpty());
                    break;
                case "top":
                    System.out.println(s.getTop());
                    break;
                default:
                    break;
            }

        }

    }


}

class MyStack{
    private Node head;
    private int size=0;
    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
            this.next=null;
        }
    }
    public int getTop(){
        if(head==null)
            return -1;
        else
            return head.value;
    }
    public int isEmpty(){
        if(head==null)
            return 1;
        else
            return 0;
    }
    public int getSize(){
        return size;
    }
    public int pop(){
        if(head==null){
            return -1;
        }
        else{
            int k=head.value;
            Node tmp=head.next;
            head.next=null;
            head=tmp;
            size--;
            return k;
        }

    }
    public void push(int value){
        Node newNode=new Node(value);

        if(head==null){
            head=newNode;

        }
        else{
            newNode.next=head;
            head=newNode;

        }
        size++;
    }
    public String toString(){
        Node tmp=head;
        String str="";

        while(tmp!=null){
            str+=tmp.value+" ";
            tmp=tmp.next;
        }
        return str;
    }
}