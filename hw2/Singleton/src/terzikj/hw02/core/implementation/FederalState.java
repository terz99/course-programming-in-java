package terzikj.hw02.core.implementation;

public class FederalState {

    private String name;
    private static FederalState[] instance = null;

    private FederalState(){}

    public static FederalState[] getInstance(){
        if(instance == null){
            instance = new FederalState[16];
            for(int i = 0; i < 4; i++){
                instance[i] = new FederalState();
                instance[i].name = "Bremen";
            }
            for(int i = 4; i < 8; i++){
                instance[i] = new FederalState();
                instance[i].name = "Bavaria";
            }
            for(int i = 8; i < 12; i++){
                instance[i] = new FederalState();
                instance[i].name = "Berlin";
            }
            for(int i = 12; i < 16; i++){
                instance[i] = new FederalState();
                instance[i].name = "Brandenburg";
            }
        }
        return instance;
    }

    /**
     * Getter for the name of the state
     * @return String - the name of the state
     * */
    public String getName() {
        return this.name;
    }

    /**
     * The setter for the name of the state
     * @param name the new name of the state
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return name;
    }
}
