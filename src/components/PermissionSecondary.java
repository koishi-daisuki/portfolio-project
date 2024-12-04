package components;

import components.set.Set;
import components.set.Set1L;;;

/**
 * Abstract class of Permission. implement key function by using kernel methods.
 *
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
    public static boolean checkUniqueness(String name) {
        return !set.contains(name);
    }

    /**
     * clear the set of name. For the use of tests only, this will make the
     * contract crash!
     */
    public static void clearSet() {
        set = new Set1L<>();
    }

    /**
     * override the equals method to compare the id since id is unique unless
     * they are constructed by newInstance() method.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof PermissionSecondary perm) {
            result = perm.getId().equals(this.getId())
                    && perm.getName().equals(this.getName())
                    && perm.getDescription().equals(this.getDescription());
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
        return this.getClass().getSimpleName() + " [id=" + this.getId()
                + ", name=" + this.getName() + ", description="
                + this.getDescription() + "]";
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
