# Fibonacci

A Jetpack Compose App which allows a user to request arbitrary numbers in the Fibonacci sequence.

# Screenshots

<p align="left">
 <img src="https://user-images.githubusercontent.com/32500878/226507250-7afd1c0f-e8c2-43a4-aa14-5152204bfb8f.png" width=30% height=30%> 
&nbsp;&nbsp;&nbsp;&nbsp;
 <img src="https://user-images.githubusercontent.com/32500878/226507252-3f72c3be-90f9-4775-a843-0ad575139176.png" width=30% height=30%>
&nbsp;&nbsp;&nbsp;&nbsp;
 <img src="https://user-images.githubusercontent.com/32500878/226507255-9d74ad8d-1ab2-4b4a-aea8-77e07ea0ac60.png" width=30% height=30%>
</p>

# Design decisions

Good decision
 * Empty state screen - Guides the user on what to do when they first install the app
 * No autosearch - Having an autosearch field would have made the state recomposition happen on every entry in the search field, hence the need to add a button for the search/request
 * Result card - Used constraint layout to align the texts. The alignment allows for emphasis of the important text(result) while still showing the time of request.
 
Poor decision
 * There is a mismatch between the words search and request. There should be a synchronized word to avoid user confusion. 
