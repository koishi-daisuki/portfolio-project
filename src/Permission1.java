import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * the default implementation of permission, that users has and used to invoke
 * command this is created for verification purpose.
 */
public final class Permission1 implements Permission {

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
    public Permission1(String name, String help) {
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

    /**
     * main method for testing.
     *
     * @param args
     */
    public static void main(String[] args) {
        Permission1 permission = new Permission1("Administrator",
                "1. the highest permission, able to execute every command");
        System.out.println(
                "permission.getDescription() = " + permission.getDescription());
        System.out.println("permission.getId() = " + permission.getId());
        System.out.println("permission.getName() = " + permission.getName());

    }

    @Override
    public void clear() {
        this.name = null;
        this.help = null;
        this.id = null;
    }

    @Override
    public Permission newInstance() {
        Class<?> clazz = this.getClass();

        try {
            Permission newPermission = (Permission) clazz
                    .getDeclaredConstructor().newInstance();
            clazz.getDeclaredField("id").set(newPermission, this.id);
            clazz.getDeclaredField("name").set(newPermission, this.name);
            clazz.getDeclaredField("help").set(newPermission, this.help);
            return newPermission;
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException | NoSuchFieldException
                | SecurityException | InvocationTargetException
                | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void transferFrom(Permission arg0) {
        assert arg0 instanceof Permission1 : ""
                + "Violation of: arg0 is of dynamic type Permission1";
        this.name = arg0.getName();
        this.help = arg0.getDescription();
        this.id = arg0.getId();
        arg0.clear();
    }

}
