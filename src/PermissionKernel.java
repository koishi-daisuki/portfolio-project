import components.standard.Standard;

/**
 * The permission users need to perform an action.
 */
public interface PermissionKernel extends Standard<Permission> {
    /**
     * return the unique id of the permission.
     *
     * @requires this != null
     * @ensures getId = this.id
     * @return id
     */
    String getId();

    /**
     * return the name of the permission.
     *
     * @requires this != null
     * @ensures getName = this.name
     * @return name.
     */
    String getName();
}
