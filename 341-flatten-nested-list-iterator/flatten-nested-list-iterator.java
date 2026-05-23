/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> ans = new ArrayList<>();
    int index = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        getElement(nestedList);

    }
    public void getElement(List<NestedInteger> nestedList){
        int n = nestedList.size();
        for(int i = 0 ; i < n ; i++){
            if(nestedList.get(i).isInteger()){
                ans.add(nestedList.get(i).getInteger());
            }else{
                getElement(nestedList.get(i).getList());
            }
        }
    }
    @Override
    public Integer next() {
        return ans.get(index++);
    }

    @Override
    public boolean hasNext() {
        return (index < ans.size());
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */