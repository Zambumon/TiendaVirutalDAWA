package dawa.model.valueObjects.runTime;

import dawa.model.valueObjects.stored.Item;

public interface IAcces {

    /**
     * @param permission enum with the permission that we want to know if the implemented has
     * @return true if it has permission
     */
    boolean hasPermision(Permission permission);


    /**
     *
     * @param item item we want to see if the implemented can comment
     * @return true if it can
     */
    boolean canComentItem(Item item);

}
