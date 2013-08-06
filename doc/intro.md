# Introduction to file-tracker

file-tracker is a library for clojure to tracking File & Directory change.

Although Java has a method lastModified to check file update.
But directory's lastModified will change only when directory children-tree updated.

But in my working project, I need to detect directory children-files contents change.
So in this library treat children-files change as directory update.  
