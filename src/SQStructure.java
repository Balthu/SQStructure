import java.util.Arrays;
import java.util.Optional;

/**
 * Author : Balthu
 * Date : 2024-11-01
 * Version : 1.0
 * Abstract base class SQStructure provides a dynamic array structure with
 * automatic resizing capabilities, designed to support data structures like
 * Stack, Queue, and advanced structures with index-based control, such as RotatingQueue.
 * This class manages dynamic resizing of the internal array when elements
 * are added or removed. It provides methods for subclasses to increment and
 * decrement the element count, retrieve, and modify elements at specific indexes.
 * RotatingQueue, a subclass, uses an additional bottom index to manage circular
 * index rotation, offering a unique approach to element access in a queue structure.
 */
public abstract class SQStructure {

    private int[] array; // Internal array to hold the elements
    private int nbElement; // Number of elements currently in the array
    private final int step; // Step size for array resizing

    /**
     * Default constructor initializes the structure with a default step size of 10.
     */
    SQStructure(){
        this(10);
    }

    /**
     * Constructor that initializes the structure with a specified step size.
     *
     * @param step the resizing step, used to increase or decrease the array size.
     */
    SQStructure(int step){
        this.step = Math.abs(step);
        array = new int[10];
        nbElement = 0;
    }

    /**
     * Adds an element to the structure, resizing the internal array if necessary.
     *
     * @param value the integer value to be added to the structure.
     */
    public void Push(int value){
        increaseArray();
        array[Count()] = value;
        incrementNbElement();

    }

    /**
     * Abstract method for removing an element from the structure.
     * This method is to be defined in subclasses.
     *
     * @return an {@link Optional} containing the removed element if available,
     *         or {@link Optional#empty()} if the structure is empty.
     */
    public abstract Optional<Integer> Pop();

    /**
     * Returns the number of elements currently in the array.
     *
     * @return the current count of elements in the array.
     */
    public int Count(){
        return nbElement;
    }

    /**
     * Returns the current size of the internal array.
     *
     * @return the length of the internal array.
     */
    public int Size(){
        return array.length;
    }

    /**
     * Clears the structure by setting all elements to zero and resetting the element count.
     */
    public void Clear(){
        Arrays.fill(array, 0);
        nbElement = 0;
    }

    /**
     * Decrements the element count, reducing the total element count by one.
     */
    protected void decrementNbElement(){
        nbElement--;
    }

    /**
     * Increments the element count, increasing the total element count by one.
     */
    protected void incrementNbElement(){
        nbElement++;
    }

    /**
     * Reduces the size of the internal array if the element count is sufficiently
     * below the current array length.
     */
    protected void decreaseArray(){
        if (nbElement < Size() - step) {
            array = Arrays.copyOf(array, Size() - step / 2);
        }
    }

    /**
     * Increases the size of the internal array by the step size if the array
     * is currently full.
     */
    protected void increaseArray(){
        if(nbElement == Size()){
            array = Arrays.copyOfRange(array, 0, Size() + step);
        }
    }

    /**
     * Shifts all elements in the array to the left, effectively removing the
     * element at index 0. The last position in the array is left uninitialized.
     */
    protected void translateArray(){
        array = Arrays.copyOfRange(array, 1, Size() + 1);
    }

    /**
     * Retrieves the element at the specified index in the internal array.
     *
     * @param index the index of the element to retrieve.
     * @return the element at the specified index.
     */
    protected int getArrayValue(int index){
        return array[index];
    }

    /**
     * Sets the element at the specified index in the internal array.
     *
     * @param index the index at which to set the value.
     * @param value the value to set at the specified index.
     */
    protected void setArrayValue(int index, int value){
        array[index] = value;
    }
}
