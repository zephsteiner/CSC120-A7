Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?

In the Cafe class, I overloded the constructor to create both a default, no-input constructor as well as one to create just a single-floor building with more ease. I also overloaded the sellCoffee method to allow for more ease in selling just black coffee.

In the Library class, I chose to overload only the constructor, creating two more versions of it. One is default with no inputs and the other allows for libraries inside of other buildings to be constructed. This makes use of the new 'building' attribute I added to Library. (This meant I also had to override the getAddress() method to communicate this information.)

In the House class, I overloaded only the constructor. Similar to Library, one is default no-input constructor and the other is to account for dining-only houses (there's only one on campus but I thought Dawes gluten-free kitchen deserved to be included as a house too). 

I had fun with this assignment, especially trying to figure out the loop. I didn't spend too long on it, since it was not actually for points, but managed to construct a semi-functional bit of code. Sure, it only works for the Building class specifically and doesn't know how to handle anything going wrong but it kinda works! AS such, what did not work is really only about the loop. Could not figure out how to make the loop account for Houses or Libraries so I think the for-loop I have right now is perhaps the wrong way to go about it. I also don't super understand Scanner & the system input (and how the two work together), which posed some problems for me here.