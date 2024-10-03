/**
 * The permission users need to perform an action.
 */
public interface PermissionKernal {
    /**
     * return the unique id of the permission.
     *
     * @return id
     */
    String getId();

    /**
     * return the name of the permission.
     * @return name.
     */
    String getName();
}
