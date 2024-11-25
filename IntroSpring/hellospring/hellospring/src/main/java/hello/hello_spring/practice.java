package hello.hello_spring;

public class practice {
    static class Umbo<K,V,A,B,C>{
        K key;
        V value;
        A a;
        B b;
        C c;

        public Umbo(K key, V value, A a, B b, C c) {
            this.key = key;
            this.value = value;
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public final K getKey(){
            return key;
        }
        public final V getValue(){
            return value;
        }
        public final A getA(){
            return a;
        }
        public final B getB(){
            return b;
        }
        public final C getC(){
            return c;
        }
    }
    public static void main(String[] args){
        Umbo um = new Umbo<>( 1, "abc", 2, 3, 4);
        System.out.println(um.getValue());
        System.out.println(um.getA());
        System.out.println(um.getB());
        System.out.println(um.getC());
        System.out.println(um.getValue().getClass());
    }

}
