package com.oanhkieu.th2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.oanhkieu.th2.model.Singer;
import com.oanhkieu.th2.model.Song;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private final static String DATABASE_NAME="OANHKIEU.DB";
    private final static int DATABASE_VERSION=1;


    public Database(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table singers (" +
                "singerId integer primary key autoincrement," +
                "singerName text,"+
                "image integer,"+
                "songInfo text)";
        db.execSQL(sql);

        sql = "create table songs (" +
                "songId integer primary key autoincrement," +
                "songName text," +
                "singerId integer," +
                "album text," +
                "type text," +
                "isLike integer," +
                "foreign key(singerId) references singers(id))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertSinger(Singer singer){
        String sql= "insert into singers (singerName,image) values(?,?)";
        String[] arg= {singer.getSingerName(),String.valueOf(singer.getImage()),singer.getSongInfo()};
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL(sql,arg);
        db.close();
    }
    public void insertSong(Song song){
        String sql="insert into songs(songName,singerID,album,type,isLike) values(?,?,?,?,?)";
        String[] args={song.getSongName(),String.valueOf(song.getSinger().getSingerId()),song.getAlbum(),song.getType(),String.valueOf(song.isLike())};
    }
    public List<Singer> getAllSinger(){
        List<Singer> result= new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        Cursor rs= db.query("singers",null,null,null,null,null,null);
        while(rs!=null && rs.moveToNext()){
            result.add(new Singer(rs.getInt(0),rs.getString(1),rs.getInt(2), rs.getString(3)));
        }
        db.close();
        return result;
    }
// lay danh sach bai hat
    public List<Song> getAllSong(){
        List<Song> result= new ArrayList<>();
        String sql= "select songs.songId,songs.songName, songs.album, songs.type, songs.isLike, " +
                " singers.singerId, singers.singerName, singers.image,singers.songInfo from singers " +
                "inner join songs" +
                " on singers.singerId = songs.singerId";
        SQLiteDatabase db= getReadableDatabase();
        Cursor rs= db.rawQuery(sql,null);
        while (rs!=null && rs.moveToNext()){
            result.add(new Song(rs.getInt(0),
                    rs.getString(1),
                    new Singer(rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8)
                    ),rs.getString(2),rs.getString(3),rs.getInt(4)==1));
        }
        db.close();
        return result;

    }
// tim kiem theo album
    public List<Song> searchSongByAlbum(String album){
        List<Song> result= new ArrayList<>();
        String sql= "select songs.songId,songs.songName, songs.album, songs.type, songs.isLike, " +
                " singers.singerId, singers.singerName, singers.image, singers.songInfo from singers " +
                "inner join songs" +
                " on singers.singerId = songs.singerId where songs.album = "+album;
        SQLiteDatabase db= getReadableDatabase();
        Cursor rs= db.rawQuery(sql,null);
        while (rs!=null && rs.moveToNext()){
            result.add(new Song(rs.getInt(0),
                    rs.getString(1),
                    new Singer(rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8)
                    ),rs.getString(2),rs.getString(3),rs.getInt(4)==1));
        }
        db.close();
        return result;
    }


}
