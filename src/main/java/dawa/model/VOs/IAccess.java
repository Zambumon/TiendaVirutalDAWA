package dawa.model.VOs;

public interface IAccess {

    /**
     * @param permission enum with the permission that we want to know if the implemented has
     * @return true if it has permission
     */
    boolean hasPermission(Permission permission);


    /**
     *
     * @param item item we want to see if the implemented can comment
     * @return true if it can
     */
    boolean canCommentItem(Item item);

}
