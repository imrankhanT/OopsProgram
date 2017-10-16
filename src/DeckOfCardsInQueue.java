
public class DeckOfCardsInQueue {
	private Node front, rear; 
	private int currentSize; // number of items 

	private class Node//linked list
	{ 
		String data;
		Node next;
	} 
	public DeckOfCardsInQueue()//constructor
	{
		front = null;
		rear = null;
		currentSize = 0;
	}
	public boolean isEmpty()
	{
		return (currentSize == 0);
	}
	public void push(String data)
	{
		Node oldRear = rear;
		rear = new Node();
		rear.data = data;
		rear.next = null;
		if (isEmpty()) 
		{
			front = rear;
		}
		else 
		{
			oldRear.next = rear;
		}
		currentSize++;
		System.out.println(data);
	}
	public static void main(String[] args) {
		DeckOfCardsInQueue queue=new DeckOfCardsInQueue();

        String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
        					"Jack", "Queen", "King", "Ace"};
        int n = SUITS.length * RANKS.length;
        String[] deck = new String[n];
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
        String arr[][]=new String[SUITS.length][9];
        for(int i=0; i<SUITS.length-1; i++)
        {
        System.out.println("Player "+(i+1));
        for(int j=0; j<9; j++)
        {
        	arr[i][j]=deck[i+j];
        	queue.push(arr[i][j]);
        }
        System.out.println();
        }
	}

}
