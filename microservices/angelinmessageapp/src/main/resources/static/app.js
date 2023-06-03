document.addEventListener("DOMContentLoaded", function() {
    const messageInput = document.getElementById("message-input");
    const sendButton = document.getElementById("send-button");
    const messagesContainer = document.getElementById("messages");

    // Establish WebSocket connection
    const socket = new WebSocket("ws://localhost:8080/chat-websocket");

    // Event listener for WebSocket connection open
    socket.onopen = function() {
        console.log("WebSocket connection established.");
    };

    // Event listener for WebSocket messages received
    socket.onmessage = function(event) {
        const message = JSON.parse(event.data);
        displayMessage(message);
    };

    // Event listener for WebSocket connection close
    socket.onclose = function(event) {
        console.log("WebSocket connection closed.");
    };

    // Event listener for send button click
    sendButton.addEventListener("click", function() {
        const messageText = messageInput.value.trim();

        if (messageText !== "") {
            const message = {
                text: messageText
            };

            // Send message through WebSocket
            socket.send(JSON.stringify(message));
            messageInput.value = "";
        }
    });

    // Display message in the chat window
    function displayMessage(message) {
        const messageElement = document.createElement("div");
        messageElement.textContent = message.text;
        messagesContainer.appendChild(messageElement);
    }
});
