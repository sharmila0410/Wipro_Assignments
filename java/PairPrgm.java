public class PairPrgm<K, V>{
    private K key;
    private V value;

    public PairPrgm(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public void setKey(K key){
        this.key = key;
    }
    public void setValue(V value){
        this.value = value;
    }
    public PairPrgm<V, K> reverse(){
        return new PairPrgm<>(value, key);
    }
    public static void main(String[]args){
        PairPrgm<String, Integer> originalPair = new PairPrgm<>("Welcome", 410);

        System.out.println("original pair:"+originalPair.getKey()+",value="+originalPair.getValue());

        PairPrgm<Integer, String> reversedPair = originalPair.reverse();

        System.out.println("reversed pair:key="+reversedPair.getKey()+",value="+reversedPair.getValue());
    }
}