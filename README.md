# Time-Incrementer-Project

This project was my first independent project, done as a submission for an internship application. These were the guidelines for the project:

Create a comprehensive counter library to be used by other developers in their applications. The core
functionality of the library should increment/decrement using a time based format (60 seconds in a minute, 60
minutes in an hour, 24 hours in a day, etc.).

The counter may be initialized to any time, but once initialized can only be incremented or decremented from.
The smallest increment should be a second and the largest increment an hour, but ensure the implementation is easy
to expand upon and handles for both positive and negative adjustments. Do not include day as part of the counter, in
situations where the provided increment would change the day, simply roll over/under the time (similar to a clock).
Display output should be made available for both standard and military time.

Note that this project is NOT a clock, increments are not made “per second” and there should be no
integration with any pre-existing system-time libraries. Increments can be made at any interval and to any logical
boundary (hour, minute, or second), but MUST be limited to increments of one (i.e. in order to add two hours to the
counter, hour must be incremented twice, or minute 120 times, or second 7200 times). Make sure to protect the
code as best as possible to prevent circumvention of the intended functionality.

Write a separate, automated, unit test stub, to completely validate the entire library’s functionality. Make the
stub easy to use and understand; as routinely this stub may be used in regression testing by other individuals.
