/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.auth.msvcauth.Menu.MenuService;

import com.auth.msvcauth.Menu.MenuEntity.DTOMenu;
import com.auth.msvcauth.Menu.MenuEntity.Menu;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gabriel
 */
public interface IServiMenu {
    
    
    public List<Menu> TraerMenu(Set<String> rol);
    
    public String InsertMenu(Menu data);
    public String InsertAllMenu(List<Menu> data);
    
    
    
}
