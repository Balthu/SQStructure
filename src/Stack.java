import java.util.Optional;

/**
 * The Stack class extends SQStructure to implement a last-in, first-out (LIFO) stack data structure.
 * Elements are pushed to the top of the stack and removed in reverse order, with the most recent
 * element being removed first. The internal array is resized dynamically as elements are added or removed.
 */
public class Stack extends SQStructure {


    /**
     * Default constructor initializes the Stack with default settings from SQStructure.
     */
    Stack() {
        super();
    }

    /**
     * Removes and returns the most recent element added to the stack.
     * This operation returns the top element if the stack is not empty, and
     * adjusts the stack size if necessary.
     * @return an {@link Optional} containing the removed element if the stack is non-empty,
     *         or {@link Optional#empty()} if the stack is empty.
     */
    @Override
    public Optional<Integer> Pop() {
        if (Count() <= 0) {
            return Optional.empty();
        } else {
            decrementNbElement();
            int value = getArrayValue(Count());
            setArrayValue(Count(), 0);
            decreaseArray();
            return Optional.of(value);
        }
    }
}