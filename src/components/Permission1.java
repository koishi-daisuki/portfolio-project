package components;
// import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * the default implementation of permission, that users has and used to invoke
 * command this is created for verification purpose.
 *
 * @convention <pre>
 * Permission = <id,"name","description"> convention: for any p1,p2
 * with type Permission, p1.id != p2.id. and p1.name != p2.name
 * </pre>
 *
 * @correspondence <pre>
 * $this = ($this.id, $this.name, $this.description).
 * </pre>
 */
public final class Permission1 extends PermissionSecondary {

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
    private String description;

    /**
     * the unique id the permission has.
     */
    private String id;

    /**
     * the full arg constructor.
     *
     * @param name
     *            the name of this permission
     * @param description
     *            the description text of the permission
     */
    public Permission1(String name, String description) {
        this.name = name;
        assert addToSet(name);
        if (description.startsWith(name + ":\n")) {
            this.description = description;
        } else {
            this.description = name + ":\n" + description;
        }
        this.id = UUID.randomUUID().toString();
    }

    /**
     * the private constructor for newInstance method.
     */
    private Permission1() {
    }

    @Override
    public String getDescription() {

        return this.description;
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
                "Administrator:\n"
                        + "1. the highest permission, able to execute every command");
        System.out.println(
                "permission.getDescription() = " + permission.getDescription());
        System.out.println("permission.getId() = " + permission.getId());
        System.out.println("permission.getName() = " + permission.getName());
        boolean setDescription = permission.setDescription("Administrator:\n"
                + "1. the highest permission, able to execute every command 1");
        assert setDescription;
        permission.setName("Admin");
        System.out.println(
                "permission.getDescription() = " + permission.getDescription());
        System.out.println("permission.getId() = " + permission.getId());
        System.out.println("permission.getName() = " + permission.getName());

    }

    @Override
    public void clear() {
        removeFromSet(this.name);
        this.name = "default";
        this.description = "default:\ndefault";
    }

    @Override
    public Permission newInstance() {
        Class<?> clazz = this.getClass();

        try {
            clazz.getDeclaredConstructor().setAccessible(true);
            Permission newPermission = (Permission) clazz
                    .getDeclaredConstructor().newInstance();
            clazz.getDeclaredField("id").setAccessible(true);
            clazz.getDeclaredField("id").set(newPermission, this.id);
            clazz.getDeclaredField("name").setAccessible(true);
            clazz.getDeclaredField("name").set(newPermission, this.name);
            clazz.getDeclaredField("description").setAccessible(true);
            clazz.getDeclaredField("description").set(newPermission,
                    this.description);
            return newPermission;
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException | SecurityException
                | InvocationTargetException | NoSuchMethodException
                | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void transferFrom(Permission arg0) {
        assert arg0 instanceof Permission1 : ""
                + "Violation of: arg0 is of dynamic type Permission1";
        this.name = arg0.getName();
        this.description = arg0.getDescription();
        this.id = arg0.getId();
        arg0.clear();
    }

    @Override
    public boolean setName(String name) {
        if (super.checkUniqueness(name)) {
            if (!this.name.isBlank()) {
                removeFromSet(this.name);
            }
            this.description = this.description.replace(this.name, name);
            this.name = name;
            addToSet(name);
            return true;
        }
        return false;
    }

    @Override
    public boolean setDescription(String description) {
        if (description.startsWith(this.name + ":\n")) {
            this.description = description;
            return true;
        }
        return false;
    }

}
