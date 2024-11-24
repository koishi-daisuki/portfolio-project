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

    /**
     * set the name of the permission.
     *
     * @param name
     *            the new name of the permission
     * @requires this != null && name != null && there does not exist a
     *           permission called "name"
     * @ensures this.name = setName
     * @return whether the
     */
    boolean setName(String name);

    /**
     * set the descriptive text including list of commands.
     *
     * @param description
     *            the new description of the permission
     * @requires this != null this = this.name +"\n" + this.help
     * @ensures this.description = description
     * @return whether the description is set successfully.
     */
    boolean setDescription(String description);

}
