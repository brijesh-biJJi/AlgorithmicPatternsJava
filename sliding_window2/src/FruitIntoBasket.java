import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given the Integer Array trees, return the maximum number of fruits you can pick.
 */
public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] trees = {0,1,6,6,4,6};
        int result = fruitIntoBasket(trees);
        System.out.println("Maximum number of fruits : "+result);
    }

    private static int fruitIntoBasket(int[] trees) {
        int max = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Boolean> treeTypesMap = new LinkedHashMap<>();

        for(int treeType : trees){
            end++;
            if(treeTypesMap.size() < 2 && !treeTypesMap.containsKey(treeType)){
                treeTypesMap.put(treeType, true);
                max = Math.max((int)max, (int)(end - start + 1));
            }
            else if(treeTypesMap.containsKey(treeType))
                max = Math.max((int)max, (int)(end - start + 1));
            else{
                treeTypesMap = new LinkedHashMap<>();
                treeTypesMap.put(trees[end - 1], true);
                treeTypesMap.put(treeType, true);
                start = end - 1;

                // Check for similar type of fruit backward
                while(trees[start] == trees[start - 1])
                    start--;

                max = Math.max((int)max, (int)(end - start + 1));
            }
        }
        return (int)max;
    }
}
