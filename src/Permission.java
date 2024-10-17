/**
 * The permission users need to perform an action, including add and remove
 * actions.
 */
public interface Permission extends PermissionKernel {

    /**
     * Returns the descriptive text including list of commands.
     *
     * @ensures contains(getDescription(), getName()) &&
     *          contains(getDescription(), getId())
     * @return the description text.
     */
    String getDescription();
}
