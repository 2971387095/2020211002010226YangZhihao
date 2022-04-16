package com.YangZhihao.dao;

import com.YangZhihao.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Userdao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
        ps.setLong(1,user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getGender());
        ps.setDate(6,user.getBirthdate());
        ps.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        PreparedStatement ps = con.prepareStatement("delete from student where id = ?");
        ps.setLong(1, user.getId());
        ps.executeUpdate();
        return 1;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        PreparedStatement ps = con.prepareStatement("update student set username = ?,password = ?,email = ?,gender = ?,birth = ? where id = ?");
        ps.setLong(1,user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getGender());
        ps.setDate(6,user.getBirthdate());
        ps.executeUpdate();
        return 1;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="Select * from student where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setLong(1,id);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("passsword"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
       String sql="Select * from student where username = ? and password = ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
        user=new User();
        user.setId(rs.getLong("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("passsword"));
        user.setEmail(rs.getString("email"));
        user.setGender(rs.getString("gender"));
        user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="Select * from student where username = ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("passsword"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="Select * from student where password = ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("passsword"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="Select * from student where email = ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("passsword"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="Select * from student where gender = ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("passsword"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="Select * from student where birthdate= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("passsword"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from student";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        User users = null;
        while (rs.next()) {
            users = new User();
            users.setId(rs.getLong("id"));
            users.setUsername(rs.getString("username"));
            users.setPassword(rs.getString("password"));
            users.setEmail(rs.getString("email"));
            users.setGender(rs.getString("gender"));
            users.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) users;
    }
}
