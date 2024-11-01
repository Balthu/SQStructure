import java.util.Optional;

/**
 * The RotatingQueue class extends Queue to implement a rotating queue structure
 * with a dynamic "bottom" index that allows efficient addition and removal of elements
 * without shifting array elements.
 * This structure maintains a front element position (referred to as "bottom") that
 * advances with each element removal. When the end of the array is reached,
 * the "bottom" index wraps back to the start, creating a rotating effect.
 */
public class RotatingQueue extends Queue{

    private int bottom; // Index representing the front of the queue

    /**
     * Default constructor initializes the RotatingQueue with default settings
     * from Queue and sets the bottom index to 0.
     */
    RotatingQueue(){
        super();
        bottom = 0;
    }

    /**
     * Adds an element to the end of the rotating queue, expanding the array size if necessary.
     * The method calculates the position based on the "bottom" index and current count,
     * and wraps around to the start if it reaches the array's end.
     * @param value the integer value to be added to the queue.
     */
    @Override
    public void Push(int value) {

        increaseArray();

        int index = bottom + Count();
        if(index >= Size()){
            index -= Size();
        }
        setArrayValue(index, value);
        incrementNbElement();
    }

    /**
     * Removes and returns the front element in the rotating queue.
     * This method retrieves the element at the "bottom" index, then increments
     * the index, wrapping it back to the start of the array if it reaches the end.
     * @return an {@link Optional} containing the removed element if the queue is non-empty,
     *         or {@link Optional#empty()} if the queue is empty.
     */
    @Override
    public Optional<Integer> Pop() {

        if (Count() <= 0) {
            return Optional.empty();
        }
        else {
            int value = getArrayValue(bottom);
            setArrayValue(bottom, 0);
            decrementNbElement();

            bottom++;
            if(bottom == Size()){
                bottom = 0;
            }
            return Optional.of(value);

        }
    }

    /**
     * Clears all elements from the rotating queue, resets the element count,
     * and sets the bottom index back to 0.
     */
    @Override
    public void Clear(){
        super.Clear();
        bottom = 0;
    }
}
