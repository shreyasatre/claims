package org.troytemple.dao;


import org.troytemple.dao.model.tblUsers;

/**
 * This class is an Interface for the Implementation of Create, Read, Update and Delete operation for Users table.
 *
 * Created by Krishnakumar Devarajan on 1/30/2016.
 */

public interface IUserDAO  {

    public tblUsers getUserDetails();
}
