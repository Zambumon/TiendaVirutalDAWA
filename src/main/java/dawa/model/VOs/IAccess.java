package dawa.model.VOs;

@SuppressWarnings("unused")
public interface IAccess {

    /**
     * @param permission enum with the permission that we want to know if the implemented has
     * @return true if it has permission
     */
    boolean hasPermission(Permission permission);

}
