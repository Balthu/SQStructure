import java.util.Optional;

/**
 * The Queue class extends SQStructure to implement a first-in, first-out (FIFO) queue data structure.
 * Elements are added to the end of the queue and removed from the beginning, maintaining a
 * sequential order. The internal array is resized dynamically as elements are added or removed.
 */
public class Queue extends SQStructure {

    /**
     * Default constructor initializes the Queue with default settings from SQStructure.
     */
    Queue() {
        super();
    }

    /**
     * Removes and returns the oldest element in the queue.
     * This operation removes the element at the front of the queue if it is not empty, shifts all
     * remaining elements forward, and adjusts the queue size if necessary.
     * @return an {@link Optional} containing the removed element if the queue is non-empty,
     *         or {@link Optional#empty()} if the queue is empty.
     */
    @Override
    public Optional<Integer> Pop() {
        if (Count() <= 0) {
            return Optional.empty();
        } else {
            decrementNbElement();
            int value = getArrayValue(0);
            translateArray();
            decreaseArray();
            return Optional.of(value);
        }
    }
}
