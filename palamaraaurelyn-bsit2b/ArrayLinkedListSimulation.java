/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraylinkedlistsimulation;

// Name: [Palamara Aurelyn May B]
// Section: [bsit-2b]
// Date: 2025-09-8

public class ArrayLinkedListSimulation {
    private int[] array;
    private int size; // current number of elements
    private static final int INITIAL_CAPACITY = 5;

    // Constructor
    public ArrayLinkedListSimulation() {
        array = new int[INITIAL_CAPACITY];
        size = 0;
    }

   
    public void add(int value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

   
    public int poll() {
        if (size == 0) {
            return -1; // array is empty
        }
        int first = array[0];
        for (int i = 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return first;
    }

    
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return array[0];
    }

    
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int last = array[size - 1];
        size--;
        return last;
    }

    
    private void resize() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    
    public void printArray() {
        System.out.print("Current array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        ArrayLinkedListSimulation list = new ArrayLinkedListSimulation();

        // Test add
        System.out.println("Adding elements:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.printArray();

        
        System.out.println("Poll: " + list.poll());
        list.printArray();

        
        System.out.println("Peek: " + list.peek());
        list.printArray();

        
        System.out.println("Pop: " + list.pop());
        list.printArray();

        
        list.add(60);
        list.add(70);
        list.add(80);
        list.printArray();

       
        System.out.println("Final peek: " + list.peek());
        System.out.println("Final pop: " + list.pop());
        list.printArray();
    }
}