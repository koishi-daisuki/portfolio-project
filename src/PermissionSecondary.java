/**
 * Abstract class of Permission. implement key function by using kernel methods
 */
public abstract class PermissionSecondary implements Permission {

    /**
     * override the equals method to compare the id since id is unique unless
     * they are constructed by newInstance() method.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof PermissionSecondary perm) {
            result = perm.getId().equals(this.getId());
        }

        return result;
    }

    /**
     * override the hashCode method to return the hash code of the object. since
     * the id is unique for every permission with single name, the hash code of
     * the id is returned.
     */
    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    /**
     * standard output of toString method.
     */
    @Override
    public String toString() {
        return this.getClass().getName() + " [id=" + this.getId() + ", name="
                + this.getName() + ", description=" + this.getDescription()
                + "]";
    }

}
