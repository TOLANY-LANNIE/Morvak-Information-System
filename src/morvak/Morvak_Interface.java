/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morvak;

/**
 *
 * @author dell
 */
public interface Morvak_Interface {
    void Save();
    void Delete();
    void Update();
    void New();
    void Combo_Populate(String query, String column);
    void Table_Populate(String query);
 
}
