/**
 * The permission users need to perform an action, including add and remove actions.
 */
public interface PermissionSecondary extends PermissionKernal {

    /**
     * Returns the descriptive text including list of commands.
     * @return the description text.
     */
    String getDescription();
}
