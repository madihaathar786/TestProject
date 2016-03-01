



1. What is the major difference between an abstract class and an interface ?

- Abstract class do have fields but Interface dont have fields.
- Abstract classes do have so default implementation interfaces have just method signatures without implementation
- Abstract classes are used when the application have variety of similar elements related with is-a relationship, On the other hand interfaces are used when your application have different elements sharing is-capable-of functionality.
- A concrete class can only extend a single abstract class while a class can implement multiple interfaces.



2. Why is Java 7’s class inheritance flawed?
I dont know

3. What are the major differences between Activities and Fragments ?
Fragment are reusable UI components , they are used within an activity. In other words Activity contains fragments.
Fragment cant exists independently moreover fragments life cycle is dependent on activties life cycle.

4. When using Fragments , how do you communicate back to their hosting Activity ?
Within a fragment we have getActivity() method which returns fragment's hosting activity and with using it we can call accessors getters whatever method we want.

5. Can you make an entire app without ever using Fragments ? Why or why not?
Are there any special cases when you absolutely have to use or should use
Fragments?
Yes we can make an entire app without fragments but use of fragments recommended because of the below reasons

Fragments use display space on screeens efficeintly.
Frgametns are used to resolve compatiblity issues when your app is targeting multiple screen sizes
With Fragments we can reuse same UI componetns in different activities without rewriting the code


6. What makes an AsyncTask such an annoyance to Android developers? Detail
some of the issues with AsyncTask , and how to potentially solve them

we normaly use it as

class MyActivty extends Activity{


class MyAsynTask extends AsycnkTasky<>{


}}
When using above way Asynctasks has implicit instance of its activty when a configuration change occurs the activity is destroyed but not GCd until the asynctask completes. so this may lead to memory leak issues if several asynctasks are started, we canresolve it by using asynchtask in its own seperate class.we can also cancel the asynchtask when our activty finishes.

protected void onPause() {

  super.onPause();
  if ((task != null) && (isFinishing()))
    task.cancel(false);
}

Also you lose your results when activity is recreated when configurations changes because asynctask have an invalid activty reference, this is resolved by keeping hold on reference of asynctask between configuration change cycle.