import components.Permission;
import components.Permission1;

/**
 * PermissionDemo. Use cases for Permission.
 */
public final class PermissionDemo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private PermissionDemo() {
    }

    /**
     * show usage of one permission instance.
     */
    public static void usage1() {
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

    /**
     * show usage of permission instances in a list.
     */
    public static void usage2() {
        // construct basic permission.
        Permission admin = new Permission1("Administrator", "Administrator:\n"
                + "1. the highest permission, able to execute every command");
        Permission user = new Permission1("User", "User:\n"
                + "1. the default permission give to every user who joined in the group\n"
                + "2. able to talk and chat in the group, execute some commands");
        Permission guest = new Permission1("Guest", "Guest:\n"
                + "1. the permission give to the user who did not join in the "
                + "group, as a visitor to the group, following the group "
                + "permission for chatting and talking\n");
        Permission blackList = new Permission1("BlackList", "BlackList:\n"
                + "1. the permission give to the user who no longer allowed to joined in the group\n"
                + "2. unable to talk and chat in the group, execute any commands");
        Permission[] permissions = { admin, user, guest, blackList };
        // generate a list of desctription for all permissions.
        for (Permission permission : permissions) {

            System.out.println("permission.getId() = " + permission.getId());
            System.out.println("permission.getDescription() = "
                    + permission.getDescription());
        }

        // assume we got a permission from a User object.
        // (in this case `userPermission` is got from our database of User)
        Permission userPermission = user;

        // check the permission of the user and give different output.
        switch (userPermission.getName()) {
            case "Administrator":
                System.out.println(
                        "You are the Administrator, you can do anything.");
                break;
            case "User":
                System.out.println(
                        "You are the User, you can talk ,chat and use partial command in the group.");
                break;
            case "Guest":
                System.out.println(
                        "You are the Guest, you can only follow the group permission.");
                break;
            case "BlackList":
                System.out.println(
                        "You are the BlackList, you are not allowed to talk,"
                                + "speak or use any command in the group.");
                break;
            default:
                System.out.println("Invalid permission.");
        }
    }

    /**
     * main method for usage.
     *
     * @param args
     */
    public static void main(String[] args) {
        usage1();
        Permission1.clearSet();
        usage2();
    }
}
