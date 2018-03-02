import java.util.ArrayDeque;

public class TrainComposition {
	public ArrayDeque<Integer> deque;
	TrainComposition() {
		deque = new ArrayDeque<>();
	}
    public void attachWagonFromLeft(int wagonId) {
    	deque.addFirst(wagonId);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public void attachWagonFromRight(int wagonId) {
    	deque.addLast(wagonId);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromLeft() {
    	return deque.pollFirst();
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromRight() {
    	return deque.pollLast();
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7 
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}
