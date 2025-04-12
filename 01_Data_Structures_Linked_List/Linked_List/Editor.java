import java.util.*;

public class Editor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Start");
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrent();
        editor.undo();
        editor.displayCurrent();
        editor.undo();
        editor.displayCurrent();
        editor.redo();
        editor.displayCurrent();

        for (int i = 1; i <= 12; i++) {
            editor.addState("State " + i);
        }

        editor.displayCurrent();
        editor.undo();
        editor.displayCurrent();
    }
}

class TextNode{
  String content;
  TextNode prev, next;
  
  public TextNode(String content){
    this.content = content;
    this.next = null;
    this.prev = null;
    
  }
}

class TextEditor{
  private TextNode head, tail, current;
  private int size = 0;
  private final int LIMIT  = 10;
  
  public void addState(String content){
    TextNode newnode = new TextNode(content);
    if(head==null){
      head = tail = current = newnode;
      size =1;
      return;
    }
    
    current.next = newnode;
    newnode.prev = current;
    current = newnode;
    tail = newnode;
    size++;
    
    if(size>LIMIT){
      head = head.next;
      head.prev = null;
      size--;
    }
  }
  
  
  public void undo(){
    if(current != null && current.prev != null){
      current = current.prev;
    }
  }
  
  public void redo(){
    if(current!= null && current.next != null){
      current = current.next;
    }
  }
  
  public void displayCurrent(){
    if(current!=null){
      System.out.println("Current: "+ current.content);
    }
    else{
      System.out.println("No text available");
    }
  }
}