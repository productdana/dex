# dex
Mobile Android to-do list.

# Pre-work - dex

Dex is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Dana Tran

Time spent: 8 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

[Link to Video Walkthrough](https://www.dropbox.com/s/w31d5xp6t26x7qk/dex_v1.mp4?dl=0)

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** I found the GUI for building activities/layouts with pre-formed views interesting. The intentions seems to simplify/speed up development in some cases (such as for people not familiar with styling in Android) but may also be a little restrictive. The format of styling views in the XML files where the views are added will take some getting used to. It's more difficult to visualize the structure of the app just by reading the XML files in comparison to HTML files. I've been working with React lately so I'm more familiar with creating components where the structure/functionality are in the same files and the styling is separate.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** An ArrayAdapter is used to connect and display items from an ArrayList in a ListView. With an ArrayAdapter and ListView, we can benefit from view recycling, which minimizes memory usage and makes the app run faster. This is more noticeable as the list of items gets larger. Memory is a resource that devices are constrained by, so it is important to minimize its usage. With view recycling, instead of creating a view for each item in an ArrayList, we create only a few more views than the number of views visible on a screen at one time. Scrapped views are then reused by interchanging the data to display. `convertView` in the `getView` method of the `ArrayAdapter` is the reusable view (or row list item in this case) that is rendered after its previous data is swapped out with the new data to display from ArrayList.

## Notes

Describe any challenges encountered while building the app.

Video and slides were referencing different versions of Android Studio (and slightly different coding styles), and certain sections looked different than Android Studio today, but those resources were still useful references. I'm not an expert in Java so writing in Java was a little challenging, but there are plenty of resources online to reference and find the necessary information to accomplish my goals.

## License

    Copyright 2017 Dana Tran

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.