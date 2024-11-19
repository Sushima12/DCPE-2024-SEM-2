# https://vilsonrodrigues.medium.com/run-your-private-llm-falcon-7b-instruct-with-less-than-6gb-of-gpu-using-4-bit-quantization-ff1d4ffbabcc

from langchain import HuggingFacePipeline
from transformers import AutoTokenizer, pipeline
import torch

model = "vilsonrodrigues/falcon-7b-instruct-sharded"

tokenizer = AutoTokenizer.from_pretrained(model)

pipeline = pipeline(
    "text-generation", #task
    model=model,
    tokenizer=tokenizer,
    torch_dtype=torch.bfloat16,
    trust_remote_code=True,
    max_length=80
)

llm = HuggingFacePipeline(pipeline = pipeline, model_kwargs = {'temperature':0})

from langchain import PromptTemplate,  LLMChain

template = """
You are an intelligent chatbot. Help the following question with brilliant answers.
Question: {question}
Answer:"""
prompt = PromptTemplate(template=template, input_variables=["question"])

llm_chain = LLMChain(prompt=prompt, llm=llm)

question = "What is SCeNB in wireless tech field?" 

print(llm_chain.run(question))
