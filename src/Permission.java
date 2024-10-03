import java.util.UUID;

/**
 * the default implementation of permission, that users has and used to invoke
 * command this is created for verification purpose.
 */
public final class Permission implements PermissionSecondary {

    /**
     * the name of the permission.
     */
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * the description text of the permission.
     */
    private String help;

    /**
     * the unique id the permission has.
     */
    private String id;

    /**
     * the full arg constructor.
     *
     * @param name
     *            the name of this permission
     * @param help
     *            the description text of the permission
     */
    private Permission(String name, String help) {
        this.name = name;
        this.help = help;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String getDescription() {

        return this.name + "\n" + this.help;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
