package edu.temple.bookshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookListFragmentInterface{

    ArrayList<Book> bookArrayList;
    BookDetailsFragment bookDetailsFragment;

    boolean container2present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container2present = findViewById(R.id.container_2) != null;//true

        bookArrayList = new ArrayList<>();

        bookArrayList.add(new Book("Summer on the Bluffs: A Novel", "SUNNY HOSTIN"));
        bookArrayList.add(new Book("With Teeth: A Novel", "KRISTEN ARNETT"));
        bookArrayList.add(new Book("That Summer: A Novel", "JENNIFER WEINER"));
        bookArrayList.add(new Book("A Special Place for Women", "LAURA HANKIN"));
        bookArrayList.add(new Book("What Comes After: A Novel", "JOANNE TOMPKINS"));
        bookArrayList.add(new Book("The 4-Hour Workweek", "Timothy Ferriss"));
        bookArrayList.add(new Book("The $100 Startup", "Chris Gillebeau"));
        bookArrayList.add(new Book("Click Millionaires", "Scott Fox"));
        bookArrayList.add(new Book("The E-Myth Revisited", "Michael E. Gerber"));
        bookArrayList.add(new Book("One Last Stop", "CASEY MCQUISTON"));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_1, BookListFragment.newInstance(bookArrayList))
                .commit();

        if(container2present){
            bookDetailsFragment = new BookDetailsFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_2, bookDetailsFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void bookClicked(int position) {
        if(!container2present) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_1, BookDetailsFragment.newInstance(bookArrayList.get(position)))
                    .addToBackStack(null)
                    .commit();
        }
        else{
            bookDetailsFragment.changeBook(bookArrayList.get(position));
        }
    }
}