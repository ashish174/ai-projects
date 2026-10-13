# ai-projects

Set `ENT_OPENAI_API_KEY`, then start Ollama and pull the model:

```sh
# start ollama
ollama serve
# In another terminal: onetime
ollama pull ministral-3:8b
# Run model
ollama run ministral-3:8b

./mvnw spring-boot:run
```

- OpenAI: `GET http://localhost:8081/chat/openai?q=Hello`
- Ollama: `GET http://localhost:8081/chat/ollama?q=Hello`

Override `OLLAMA_MODEL` or `OLLAMA_BASE_URL` to use another model or server.
