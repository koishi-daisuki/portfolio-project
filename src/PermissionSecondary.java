import components.set.Set;
import components.set.Set1L;;;

/**
 * Abstract class of Permission. implement key function by using kernel methods.
 *
 * @convention <pre>
 * Permission = <id,"name","description"> convention: for any p1,p2
 * with type Permission, p1.id != p2.id. and p1.name != p2.name
 * </pre>
 *
 * @correspondence <pre>
 * $this = ($this.id, $this.name, $this.description).
 * </pre>
 *
 */
public abstract class PermissionSecondary implements Permission {
    /**
     * the set of name.
     */
    private static Set<String> set = new Set1L<>();

    /**
     * return if there are multiple instances with same name but different id.
     *
     * @param name
     *            the name want to check uniqueness.
     * @return true if the set does not contains name. else return false.
     */
    protected static boolean checkUniqueness(String name) {
        return !set.contains(name);
    }

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

    /**
     * remove the name s from the set.
     *
     * @param s
     *            the old name
     * @return whether the remove operation is successful.
     */
    public static boolean removeFromSet(String s) {
        if (set.contains(s)) {
            set.remove(s);
            return true;
        } else {
            return false;
        }
    }

    /**
     * add the name s to the list.
     *
     * @param s
     *            the new name.
     * @return whether the add operation is successful.
     */
    public static boolean addToSet(String s) {
        if (set.contains(s)) {
            return false;
        } else {
            set.add(s);
            return true;
        }
    }
}
