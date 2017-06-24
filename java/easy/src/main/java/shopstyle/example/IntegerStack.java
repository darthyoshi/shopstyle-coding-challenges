package shopstyle.example;

import java.util.Optional;

/**
 * An {@link Integer} implementation of {@link Stack}.
 *
 * <p>Instances of this class are not thread-safe.</p>
 */
final class IntegerStack implements shopstyle.example.Stack<Integer> {
  private Integer[] stack;
  private int count;

  public IntegerStack() {
    this(10);
  }

  public IntegerStack(Integer size) {
    stack = new Integer[size];
    
    for(int i = 0; i < size; i++) {
      stack[i] = null;
    }

    count = 0;
  }

  @Override
  public void push(Integer val) {
    if(count == stack.length) {
      resize();
    }

    stack[count] = val;
    count++;
  }

  @Override
  public Optional<Integer> pop() {
    Optional<Integer> result = peek();

    if(result.isPresent()) {
      count--;
      stack[count] = null;
    }

    return result;
  }

  @Override
  public Optional<Integer> peek() {
    Optional<Integer> result;

    if(count > 0) {
      result = Optional.ofNullable(stack[count-1]);
    } else {
      result = Optional.empty();
    }

    return result;
  }

  @Override
  public boolean isEmpty() {
    return count == 0;
  }

  /**
   * Doubles the current stack capacity.
   */
  private void resize() {
    Integer[] result = new Integer[stack.length*2];
    int i;

    for(i = 0; i < stack.length; i++) {
      result[i] = stack[i];
    }

    while(i < result.length) {
      result[i] = null;
      i++;
    }

    stack = result;
  }
}
