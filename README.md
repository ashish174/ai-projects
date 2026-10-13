# ai-projects

Set `ENT_OPENAI_API_KEY`, then start Ollama and pull the model:

```sh
ollama serve
# In another terminal:
ollama pull llama3.2
./mvnw spring-boot:run
```

- OpenAI: `GET http://localhost:8081/chat?q=Hello`
- Ollama: `GET http://localhost:8081/chat/ollama?q=Hello`

Override `OLLAMA_MODEL` or `OLLAMA_BASE_URL` to use another model or server.
